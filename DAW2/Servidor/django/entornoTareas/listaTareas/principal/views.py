from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect
from django.template import loader
from django.urls import reverse
from .models import Tareas

# Create your views here.
def tareas(request):
    listaTareas = Tareas.objects.all().order_by('-id').values()
    template = loader.get_template('tareas.html')
    context = {
        'tareas': listaTareas,
    }
    return HttpResponse(template.render(context, request))


def realizada(request, identificador):
    tarea = Tareas.objects.get(id=identificador)
    tarea.realizada = True
    tarea.save()
    return HttpResponseRedirect(reverse('tareas'))


def nuevaTarea(request):
    d = request.GET['desc']
    tarea = Tareas(descripcion = d, realizada = False)
    tarea.save()
    return HttpResponseRedirect(reverse('tareas'))

def borrar(request, identificador):
    tarea = Tareas.objects.get(id=identificador)
    tarea.delete()
    return HttpResponseRedirect(reverse('tareas'))