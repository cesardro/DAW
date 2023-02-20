from django.contrib import admin

# Register your models here.
from .models import Profesor, Grupo

class ProfesorAdmin(admin.ModelAdmin):
    readonly_fields = ('created','updated')
    list_display = ('apellidos', 'nombre', 'asignatura')
    ordering = ('apellidos', 'nombre')

class GrupoAdmin(admin.ModelAdmin):
    readonly_fields = ('created', 'updated')
    list_display = ('curso','letra', 'numAlumnos')
    ordering = ('curso', 'letra')

admin.site.register(Profesor, ProfesorAdmin)
admin.site.register(Grupo, GrupoAdmin) 