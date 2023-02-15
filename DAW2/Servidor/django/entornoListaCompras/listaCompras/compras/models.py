from django.db import models

# Create your models here.
class Compras(models.Model):
    producto = models.CharField(max_length=255)
    cantidad = models.FloatField()
    unidad = models.CharField(max_length=255)
    comprada = models.BooleanField()