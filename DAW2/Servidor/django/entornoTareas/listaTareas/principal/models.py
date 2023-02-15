from django.db import models

# Create your models here.
class Tareas(models.Model):
    descripcion = models.CharField(max_length=255)
    realizada = models.BooleanField()