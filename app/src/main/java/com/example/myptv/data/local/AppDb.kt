package com.example.myptv.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myptv.data.local.dao.BlockDao
import com.example.myptv.data.local.dao.CategoryDao
import com.example.myptv.data.local.dao.ChannelDao
import com.example.myptv.data.local.dao.CountryDao
import com.example.myptv.data.local.dao.GuideDao
import com.example.myptv.data.local.dao.LanguageDao
import com.example.myptv.data.local.dao.RegionDao
import com.example.myptv.data.local.dao.StreamDao
import com.example.myptv.data.local.dao.SubdivisionDao
import com.example.myptv.data.local.model.Block
import com.example.myptv.data.local.model.Category
import com.example.myptv.data.local.model.Channel
import com.example.myptv.data.local.model.Country
import com.example.myptv.data.local.model.Guide
import com.example.myptv.data.local.model.Language
import com.example.myptv.data.local.model.Region
import com.example.myptv.data.local.model.Stream
import com.example.myptv.data.local.model.Subdivision

@Database(
    entities =
    [Block::class,
        Category::class,
        Channel::class,
        Country::class,
        Guide::class,
        Language::class,
        Region::class,
        Stream::class,
        Subdivision::class],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    abstract val blockDao: BlockDao
    abstract val categoryDao: CategoryDao
    abstract val channelDao: ChannelDao
    abstract val countryDao: CountryDao
    abstract val guideDao: GuideDao
    abstract val languageDao: LanguageDao
    abstract val regionDao: RegionDao
    abstract val streamDao: StreamDao
    abstract val subdivisionDao: SubdivisionDao
}