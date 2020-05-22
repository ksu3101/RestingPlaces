package com.swkang.restingplaces.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

/**
 * 생성된 ViewModel 인스턴스를 Mutable Map 에 Key:ViewModel class type, Value: ViewModel instance
 * 로 저장하고 다른 컴포넌트에서 ViewModel 인스턴스를 필요로 할 때 해당 ViewModel 인스턴스를
 * 반환한다.
 *
 * @author kangsungwoo
 * @since 5/16/2020
 */
class ViewModelFactory @Inject constructor(
    private val vms: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return vms[modelClass]?.get() as T
    }
}

/**
 * ViewModel 을 Mutable map 에 저장하기 위한 Key의 어노테이션 클래스.
 * Dagger 의 `@MapKey` 어노테이션을 이용 하여 `value` 패러미터를
 * Map 의 Key 로 사용함을 컴파일러에 알린다.
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)