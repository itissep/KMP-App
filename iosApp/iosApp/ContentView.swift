import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var newsViewModel = NewsListViewModel()

	var body: some View {
        VStack {
            Text("there")
            ForEach(newsViewModel.news, id: \.content) { item in
                Text(item.author ?? "someone")
            }
        }.onAppear {
            newsViewModel.loadNews()
        }
	}
}
