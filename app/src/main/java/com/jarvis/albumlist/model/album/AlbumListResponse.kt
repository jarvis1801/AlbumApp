package com.jarvis.albumlist.model.album

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AlbumListResponse(
    val resultCount: Int? = null,
    @SerializedName("results") val albumList: ArrayList<Album>? = null
)

@Entity(tableName = "album")
data class Album(
    val wrapperType: String? = null,
    val collectionType: String? = null,
    val artistId: Int? = null,
    @PrimaryKey val collectionId: Int? = null,
    val amgArtistId: Int? = null,
    val artistName: String? = null,
    val collectionName: String? = null,
    val collectionCensoredName: String? = null,
    val artistViewUrl: String? = null,
    val collectionViewUrl: String? = null,
    val artworkUrl60: String? = null,
    val artworkUrl100: String? = null,
    val collectionPrice: Double? = null,
    val collectionExplicitness: String? = null,
    val trackCount: Int? = null,
    val copyright: String? = null,
    val country: String? = null,
    val currency: String? = null,
    val releaseDate: String? = null,
    val primaryGenreName: String? = null,

    var isBookmarked: Boolean? = false
)

class AlbumUpdate(album: Album) {

    val wrapperType: String? = album.wrapperType
    val collectionType: String? = album.collectionType
    val artistId: Int? = album.artistId
    val collectionId: Int? = album.collectionId
    val amgArtistId: Int? = album.amgArtistId
    val artistName: String? = album.artistName
    val collectionName: String? = album.collectionName
    val collectionCensoredName: String? = album.collectionCensoredName
    val artistViewUrl: String? = album.artistViewUrl
    val collectionViewUrl: String? = album.collectionViewUrl
    val artworkUrl60: String? = album.artworkUrl60
    val artworkUrl100: String? = album.artworkUrl100
    val collectionPrice: Double? = album.collectionPrice
    val collectionExplicitness: String? = album.collectionExplicitness
    val trackCount: Int? = album.trackCount
    val copyright: String? = album.copyright
    val country: String? = album.country
    val currency: String? = album.currency
    val releaseDate: String? = album.releaseDate
    val primaryGenreName: String? = album.primaryGenreName

}

class AlbumUpdateBookmark(album: Album, var isBookmarked: Boolean) {
    val collectionId = album.collectionId

}