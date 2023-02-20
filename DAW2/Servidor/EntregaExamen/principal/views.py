from django.shortcuts import render
from .models import Profesor, Grupo
from django.views.generic.list import ListView
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from .forms import ProfesorForm
from django.urls import reverse_lazy

# Create your views here.
class ProfesorListView(ListView):
    model = Profesor

class ProfesorCreateView( CreateView):
    model = Profesor
    form_class = ProfesorForm
    success_url = reverse_lazy('listado')

class ProfesorUpdateView(UpdateView):
    model = Profesor
    form_class = ProfesorForm
    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listado')

class ProfesorDeleteView(DeleteView):
    model = Profesor
    success_url = reverse_lazy('listado')