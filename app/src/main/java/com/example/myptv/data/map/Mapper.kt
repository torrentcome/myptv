package com.example.myptv.data.map

// remote api
typealias RemoteBlock = com.example.myptv.data.remote.model.Block
typealias RemoteCategory = com.example.myptv.data.remote.model.Category
typealias RemoteChannel = com.example.myptv.data.remote.model.Channel
typealias RemoteCountry = com.example.myptv.data.remote.model.Country
typealias RemoteGuide = com.example.myptv.data.remote.model.Guide
typealias RemoteLangage = com.example.myptv.data.remote.model.Language
typealias RemoteRegion = com.example.myptv.data.remote.model.Region
typealias RemoteStream = com.example.myptv.data.remote.model.Stream
typealias RemoteSubdivision = com.example.myptv.data.remote.model.Subdivision

// local db
typealias LocalBlock = com.example.myptv.data.local.model.Block
typealias LocalCategory = com.example.myptv.data.local.model.Category
typealias LocalChannel = com.example.myptv.data.local.model.Channel
typealias LocalCountry = com.example.myptv.data.local.model.Country
typealias LocalGuide = com.example.myptv.data.local.model.Guide
typealias LocalLangage = com.example.myptv.data.local.model.Language
typealias LocalRegion = com.example.myptv.data.local.model.Region
typealias LocalStream = com.example.myptv.data.local.model.Stream
typealias LocalSubdivision = com.example.myptv.data.local.model.Subdivision

// domain
typealias DomainBlock = com.example.myptv.domain.model.Block
typealias DomainCategory = com.example.myptv.domain.model.Category
typealias DomainChannel = com.example.myptv.domain.model.Channel
typealias DomainCountry = com.example.myptv.domain.model.Country
typealias DomainGuide = com.example.myptv.domain.model.Guide
typealias DomainLangage = com.example.myptv.domain.model.Language
typealias DomainRegion = com.example.myptv.domain.model.Region
typealias DomainStream = com.example.myptv.domain.model.Stream
typealias DomainSubdivision = com.example.myptv.domain.model.Subdivision

object Mapper {
    fun map(block: RemoteBlock) = LocalBlock(
        channel = block.channel.toString(),
        ref = block.ref
    )

    fun map(category: RemoteCategory) = LocalCategory(
        id = category.id.toString(),
        name = category.name
    )

    fun map(channel: RemoteChannel) = LocalChannel(
        id = channel.id.toString(),
        name = channel.name,
        altNames = channel.altNames.toString(),
        network = channel.network,
        owners = channel.owners.toString(),
        country = channel.country,
        subdivision = channel.subdivision,
        city = channel.city,
        broadcastArea = channel.broadcastArea.toString(),
        languages = channel.languages.toString(),
        categories = channel.categories.toString(),
        isNsfw = channel.isNsfw,
        launched = channel.launched,
        closed = channel.closed,
        replacedBy = channel.replacedBy,
        website = channel.website,
        logo = channel.logo
    )

    fun map(stream: RemoteStream) = LocalStream (
        url = stream.url,
        channel = stream.channel.toString(),
        httpReferrer = stream.httpReferrer,
        userAgent = stream.userAgent
    )

    fun map(stream: LocalStream) = DomainStream (
        url = stream.url,
        channel = stream.channel,
        httpReferrer = stream.httpReferrer,
        userAgent = stream.userAgent
    )
}