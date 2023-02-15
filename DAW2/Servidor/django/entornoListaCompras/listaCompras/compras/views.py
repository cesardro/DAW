#from django.shortcuts import render
from .models import Compras
from django.template import loader
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse

# Create your views here.
def compras(request):
    lc = Compras.objects.all()
    context = {
        'compras': lc,
    }
    plantilla = loader.get_template('compras.html')
    return HttpResponse(plantilla.render(context, request))

def nuevo(request):
    prod = request.GET['producto']
    cant = request.GET['cantidad']
    unid = request.GET['unidad']

    compra = Compras(producto=prod, cantidad=cant, unidad=unid, comprada=False) 
    compra.save()

    return HttpResponseRedirect(reverse('compras'))

def comprado(request, identificador):
    cmpr = Compras.objects.get(id=identificador)
    cmpr.comprada = True
    cmpr.save()

    return HttpResponseRedirect(reverse('compras'))

def anadir(request, identificador):
    cmpr = Compras.objects.get(id=identificador)
    cmpr.comprada = False
    cmpr.save()

    return HttpResponseRedirect(reverse('compras'))