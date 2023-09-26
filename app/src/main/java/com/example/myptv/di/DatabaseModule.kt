package com.example.myptv.di

import android.app.Application
import androidx.room.Room
import com.example.myptv.data.local.AppDb
import com.example.myptv.data.local.dao.BlockDao
import com.example.myptv.data.local.dao.CategoryDao
import com.example.myptv.data.local.dao.ChannelDao
import com.example.myptv.data.local.dao.CountryDao
import com.example.myptv.data.local.dao.GuideDao
import com.example.myptv.data.local.dao.LanguageDao
import com.example.myptv.data.local.dao.RegionDao
import com.example.myptv.data.local.dao.StreamDao
import com.example.myptv.data.local.dao.SubdivisionDao
import org.koin.dsl.module

val databaseModule = module {

    single { createAppDatabase(get()) }

    single { createBlockDao(get()) }
    single { createCategoryDao(get()) }
    single { createChannelDao(get()) }
    single { createCountryDao(get()) }
    single { createGuideDao(get()) }
    single { createLanguageDao(get()) }
    single { createRegionDao(get()) }
    single { createStreamDao(get()) }
    single { createSubdivisionDao(get()) }
}

internal fun createAppDatabase(app: Application): AppDb {
    return Room.databaseBuilder(app, AppDb::class.java, "myptv.db")
        .fallbackToDestructiveMigration()
        .build()
}

fun createBlockDao(db: AppDb): BlockDao {
    return db.blockDao
}
fun createCategoryDao(db: AppDb): CategoryDao {
    return db.categoryDao
}
fun createChannelDao(db: AppDb): ChannelDao {
    return db.channelDao
}
fun createCountryDao(db: AppDb): CountryDao {
    return db.countryDao
}
fun createGuideDao(db: AppDb): GuideDao {
    return db.guideDao
}
fun createLanguageDao(db: AppDb): LanguageDao {
    return db.languageDao
}
fun createRegionDao(db: AppDb): RegionDao {
    return db.regionDao
}
fun createStreamDao(db: AppDb): StreamDao {
    return db.streamDao
}
fun createSubdivisionDao(db: AppDb): SubdivisionDao {
    return db.subdivisionDao
}
