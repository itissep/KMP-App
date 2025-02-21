import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var newsViewModel = NewsListViewModel()

	var body: some View {
        VStack {
            Text("some news")
                .monospaced()
                .font(.title)
                .padding(.all, 16)
            ScrollView {
                if newsViewModel.news.isEmpty {
                    Spacer()
                    ProgressView()
                        .tint(.green)
                    Text("no items yet... wait a minute!")
                        .monospaced()
                        .foregroundStyle(.gray)
                        .font(.caption)
                    Spacer()
                } else {
                    ForEach(newsViewModel.news, id: \.content) { item in
                        HStack(spacing: 16) {
                            Group {
                                if
                                    let imageUrlString = item.urlToImage,
                                    let imageUrl = URL(string: imageUrlString)
                                {
                                    AsyncImage(url: imageUrl) { image in
                                        image
                                            .resizable()
                                    } placeholder: {
                                        Color.green
                                    }
                                } else {
                                    Color.green
                                        .overlay {
                                            Image(systemName: "photo.fill")
                                                .foregroundStyle(.background)
                                        }
                                }
                            }
                            .frame(width: 80, height: 80)
                            .clipShape(.rect(cornerRadius: 10))
                            
                            VStack(alignment: .leading) {
                                Text(item.author ?? "no author")
                                    .monospaced()
                                    .foregroundStyle(.gray)
                                    .font(.caption)
                                
                                Text(item.title ?? "no title")
                                    .multilineTextAlignment(.leading)
                                    .monospaced()
                            }
                            Spacer()
                        }.padding(.all, 16)
                    }
                }
            }
        }.onAppear {
            newsViewModel.loadNews()
        }
	}
}
