package com.patodev.viewmodelexample.core

import android.content.Context
import androidx.room.Room
import com.patodev.viewmodelexample.data.database.VMExampleDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DATABASE_NAME = "ViewModelExampleDB"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            VMExampleDB::class.java,
            DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun providePeopleDao(db: VMExampleDB) = db.peopleDao
}