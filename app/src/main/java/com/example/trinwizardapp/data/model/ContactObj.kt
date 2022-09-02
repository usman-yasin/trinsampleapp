package com.example.trinwizardapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ContactObj(
    @SerializedName("id")
    val contactId: String? = "",
    @SerializedName("firstName")
    var firstName: String?,
    @SerializedName("lastName")
    val lastName: String? = "",
    @field:SerializedName("email")
    val email: String? = "",
    @field:SerializedName("phone")
    val phone: String? = ""
):Parcelable  {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(contactId)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(email)
        parcel.writeString(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactObj> {
        override fun createFromParcel(parcel: Parcel): ContactObj {
            return ContactObj(parcel)
        }

        override fun newArray(size: Int): Array<ContactObj?> {
            return arrayOfNulls(size)
        }
    }
}