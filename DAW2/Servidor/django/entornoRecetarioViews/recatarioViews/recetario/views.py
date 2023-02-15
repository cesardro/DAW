from .models import Receta, Categorias
from django.views.generic.list import ListView
from django.views.generic.detail import DetailView
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from .forms import RecetaForm

from django.urls import reverse_lazy

class RecetarioListView(ListView):
    model = Receta

class RecetarioDetailView(DetailView):
    model = Receta

class RecetarioCreateView(CreateView):
    model = Receta
    form_class = RecetaForm
    success_url = reverse_lazy('listado')

class RecetarioUpdateView(UpdateView):
    model = Receta
    form_class = RecetaForm
    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listado')

class RecetarioDeleteView(DeleteView):
    model = Receta
    success_url = reverse_lazy('listado')

class RecetarioEspecificaListView(ListView):
    model = Categorias
