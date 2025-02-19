import SwiftUI
import shared

class NewsListViewModel: ObservableObject {
    
    @Published var news: [NewsItem] = []
    
    private lazy var vm: NewsViewModel? = {
         let vm = KoinDIFactory.shared.resolve(clazz_:  NewsViewModel.self) as? NewsViewModel
        vm?.newsFlow.collect(collector: itemsCollector, completionHandler: {_ in})
         return vm
     }()
    
    lazy var itemsCollector: Observer = {
        let collector = Observer { [weak self] value in
            guard let self = self else {return}
            if let value = value as? NewsList {
                self.news = value.articles ?? [NewsItem]()
            }
        }
        return collector
    }()
   
    
    func loadNews() {
        vm?.loadNews()
    }
}
