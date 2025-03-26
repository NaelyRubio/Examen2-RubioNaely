package rubio.naely.examen2_rubionaely

class ContactoHistorial {

    val contactos = mutableListOf<Contacto>()

    fun agregar(contacto: Contacto) {
        contactos.add(contacto)
    }

    fun eliminar(contacto: Contacto) {
        contactos.remove(contacto)
    }
}