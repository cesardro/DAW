from django.db import models

# Create your models here.
class Empresas(models.Model):
    nombre  = models.CharField(max_length=255, verbose_name='Nombre')
    tipo = models.CharField(max_length=255, verbose_name='Tipo')
    direccion = models.CharField(max_length=255, verbose_name='Direccion')
    telefono = models.CharField(max_length=255, verbose_name='Telefono')
    personaContacto = models.CharField(max_length=255, verbose_name='Persona de contacto')

    created = models.DateTimeField(auto_now_add=True,verbose_name='Fecha de creación')
    updated = models.DateTimeField(auto_now=True,verbose_name='Fecha de modificación')   

    def __str__(self):
        return self.nombre