package  com.gui.kmpnewsapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gui.kmpnewsapp.models.NewsList
import com.gui.kmpnewsapp.useCases.NewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val useCase: NewsUseCase) : ViewModel() {
    var newsFlow = MutableStateFlow<NewsList?>(null)

    fun loadNews() {
        viewModelScope.launch {
            val result =  useCase.invoke(Unit)
            result.getOrNull()?.let {
                newsFlow.tryEmit(it)
            }
        }
    }
}