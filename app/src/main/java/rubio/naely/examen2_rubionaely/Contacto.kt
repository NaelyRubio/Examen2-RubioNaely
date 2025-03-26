package rubio.naely.examen2_rubionaely

import android.os.Parcel
import android.os.Parcelable

data class Contacto(
    val nombre: String,
    val apellido: String,
    val compania: String,
    val correo: String,
    val telefono: String,
    val color: Int
) : Parcelable {

    // Constructor que lee los datos del parcel
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        parcel.writeString(compania)
        parcel.writeString(correo)
        parcel.writeString(telefono)
        parcel.writeInt(color)
    }

    override fun describeContents(): Int = 0

    //  implementación de Parcelable el creator que creara la instancia de la clase a partir del Parcel
    companion object CREATOR : Parcelable.Creator<Contacto> {
        override fun createFromParcel(parcel: Parcel): Contacto {
            return Contacto(parcel)
        }

        override fun newArray(size: Int): Array<Contacto?> {
            return arrayOfNulls(size)
        }
    }
}
