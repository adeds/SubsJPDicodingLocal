package ade.dicoding.sub2.util

import ade.dicoding.sub2.vo.Resource
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

object PagedListUtil {
    fun <T> mockPagedList(list: List<T>): PagedList<T> {
        val pagedList: PagedList<T> = mock(PagedList::class.java) as PagedList<T>
        val answer = Answer { invocation: InvocationOnMock ->
            val index = invocation.arguments[0] as Int
            list[index]
        }
        Mockito.`when`(pagedList[ArgumentMatchers.anyInt()]).thenAnswer(answer)
        Mockito.`when`(pagedList.size).thenReturn(list.size)
        return pagedList
    }
}