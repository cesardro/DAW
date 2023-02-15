from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect
from django.template import loader
from django.urls import reverse
from .models import Socios

# Create your views here.
def index(request):
    socios = Socios.objects.all().values()
    template = loader.get_template('interfazSocio.html')

    contexto = {
        'listaSocios': socios,
    }
    return HttpResponse(template.render(contexto, request))

def nuevo(request):
    template = loader.get_template('nuevoSocio.html')
    return HttpResponse(template.render({}, request))

def nuevoRegistro(request):
    n = request.POST['nombre']
    a = request.POST['apellidos']
    socio = Socios(nombre=n, apellidos=a)
    socio.save()
    return HttpResponseRedirect(reverse('index'))

def borrar(request, identificador):
    socio = Socios.objects.get(id=identificador)
    socio.delete()
    return HttpResponseRedirect(reverse('index'))

def modifica(request, identificador):
    socio = Socios.objects.get(id=identificador)
    template = loader.get_template('modifica.html')
    contexto = {
        'socio': socio,
    }
    return HttpResponse(template.render(contexto, request))

def modificaRegistro(request, identificador):
    n = request.POST['nombre']
    a = request.POST['apellidos']
    socio = Socios.objects.get(id=identificador)
    socio.nombre = n
    socio.apellidos = a
    socio.save()
    return HttpResponseRedirect(reverse('index'))