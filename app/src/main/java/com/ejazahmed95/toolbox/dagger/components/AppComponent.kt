package com.ejazahmed95.toolbox.dagger.components

import com.ejazahmed95.toolbox.View.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun poke(app: MainActivity)
}