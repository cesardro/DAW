from django.http import HttpResponse
from django.shortcuts import get_list_or_404, render
from .models import Empresas
from django.template import loader

from django.views.generic.list import ListView
from django.views.generic.detail import DetailView
from django.views.generic.edit import CreateView, UpdateView, DeleteView

from django.urls import reverse_lazy

class EmpresaListView(ListView):
    model = Empresas

class EmpresaDetailView(DetailView):
    model = Empresas

class EmpresaCreateView(CreateView):
    model = Empresas
    fields = ['nombre', 'tipo', 'direccion', 'telefono', 'personaContacto']
    success_url = reverse_lazy('listado')

class EmpresaUpdateView(UpdateView):
    model = Empresas
    fields = ['nombre', 'tipo', 'direccion', 'telefono', 'personaContacto']
    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listado')

class EmpresaDeleteView(DeleteView):
    model = Empresas
    success_url = reverse_lazy('listado')


# # Create your views here.
# def listado(request):
#     #Modelo
#     empresas = get_list_or_404(Empresas)

#     #Contexto
#     ctx = {
#         'empresas':empresas,
#     }
#     #Template
#     listadoHtml = loader.get_template('principal/listado.html')

#     #Return Template
#     return HttpResponse(listadoHtml.render(ctx, request))