/**
 * ownCloud Android client application
 *
 * @author Abel García de Prada
 * Copyright (C) 2022 ownCloud GmbH.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.owncloud.android.data.spaces.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.owncloud.android.data.ProviderMeta
import com.owncloud.android.data.spaces.db.SpaceSpecialEntity.Companion.SPACES_SPECIAL_ACCOUNT_NAME
import com.owncloud.android.data.spaces.db.SpaceSpecialEntity.Companion.SPACES_SPECIAL_ID
import com.owncloud.android.data.spaces.db.SpaceSpecialEntity.Companion.SPACES_SPECIAL_SPACE_ID

@Entity(
    tableName = ProviderMeta.ProviderTableMeta.SPACES_SPECIAL_TABLE_NAME,
    primaryKeys = [SPACES_SPECIAL_SPACE_ID, SPACES_SPECIAL_ID],
    foreignKeys = [ForeignKey(
        entity = SpacesEntity::class,
        parentColumns = arrayOf(SpacesEntity.SPACES_ACCOUNT_NAME, SpacesEntity.SPACES_ID),
        childColumns = arrayOf(SPACES_SPECIAL_ACCOUNT_NAME, SPACES_SPECIAL_SPACE_ID),
        onDelete = ForeignKey.CASCADE
    )]
)
data class SpaceSpecialEntity(
    @ColumnInfo(name = SPACES_SPECIAL_ACCOUNT_NAME)
    val accountName: String,
    @ColumnInfo(name = SPACES_SPECIAL_SPACE_ID)
    val spaceId: String,
    val eTag: String,
    @ColumnInfo(name = SPACES_SPECIAL_FILE_MIME_TYPE)
    val fileMymeType: String,
    @ColumnInfo(name = SPACES_SPECIAL_ID)
    val id: String,
    @ColumnInfo(name = SpacesEntity.SPACES_LAST_MODIFIED_DATE_TIME)
    val lastModifiedDateTime: String,
    val name: String,
    val size: Int,
    val specialFolderName: String,
    val webDavUrl: String
) {
    companion object {
        const val SPACES_SPECIAL_ACCOUNT_NAME = "spaces_special_account_name"
        const val SPACES_SPECIAL_SPACE_ID = "spaces_special_space_id"
        const val SPACES_SPECIAL_FILE_MIME_TYPE = "file_mime_type"
        const val SPACES_SPECIAL_ID = "special_id"
    }
}
