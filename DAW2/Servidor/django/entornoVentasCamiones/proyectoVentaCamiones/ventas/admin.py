from django.contrib import admin

# Register your models here.
from .models import Camion, Categorias

class CamionAdmin(admin.ModelAdmin):
    readonly_fields = ('created','updated')
    list_display = ('marca','modelo','author')
    ordering = ('marca', 'author')
    search_fields = ('titulo', 'marca', 'author__username', 'categorias__nombre')
    date_hierarchy = ('created')
    list_filter = ('categorias__nombre', 'author__username')

class CategoriasAdmin(admin.ModelAdmin):
    readonly_fields = ('created', 'updated')
    list_display = ('nombre','descripcion')

admin.site.register(Camion, CamionAdmin)
admin.site.register(Categorias, CategoriasAdmin) 