from django.shortcuts import render
from .models import Propositos
from django.template import loader
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from datetime import datetime, timedelta

# Create your views here.
def propositos(request):
    lc = Propositos.objects.all()
    fecha_actual = datetime.now().date()
    context = {
        'propositos': lc,
        'fechaActual': fecha_actual,
    }

    plantilla = loader.get_template('propositos.html')
    return HttpResponse(plantilla.render(context, request))

def nuevo(request):
    prop = request.GET['proposito']
    fchObj = request.GET['fechaObjetivo']

    propositos = Propositos(proposito=prop, fechaObjetivo=fchObj, conseguido=False) 
    propositos.save()

    return HttpResponseRedirect(reverse('propositos'))

def conseguido(request, identificador):
    prop = Propositos.objects.get(id=identificador)
    prop.conseguido = True
    prop.fechaConseguido = datetime.now().date()
    prop.save()

    return HttpResponseRedirect(reverse('propositos'))

def mover(request, identificador):
    lc = Propositos.objects.get(id=identificador)
    context = {
        'mover': lc,
    }
    plantilla = loader.get_template('mover.html')
    return HttpResponse(plantilla.render(context, request))

def modificar(request, identificador):
    nuevaFecha = Propositos.objects.get(id=identificador)
    numDias = int(request.GET['numDias'])
    if numDias > 0:
        nuevaFecha.fechaObjetivo = nuevaFecha.fechaObjetivo + (timedelta(days=numDias))
        nuevaFecha.save()

    return HttpResponseRedirect(reverse('propositos'))

def modProp(request, identificador):
    lc = Propositos.objects.get(id=identificador)
    context = {
        'modProp': lc,
    }
    plantilla = loader.get_template('modProp.html')
    return HttpResponse(plantilla.render(context, request))

def actualizar(request, identificador):
    nuevaFecha = Propositos.objects.get(id=identificador)
    nuevaFecha.proposito = request.GET['nuevoProp']
    nuevaFecha.save()

    return HttpResponseRedirect(reverse('propositos'))

def resetear(request, identificador):
    prop = Propositos.objects.get(id=identificador)
    prop.conseguido = False
    prop.fechaConseguido = None
    prop.save()

    return HttpResponseRedirect(reverse('propositos'))

def borrar(request, identificador):
    prop = Propositos.objects.get(id=identificador)
    prop.delete()

    return HttpResponseRedirect(reverse('propositos'))