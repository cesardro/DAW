from .models import Camion, Categorias
from django.views.generic.list import ListView
from django.views.generic.detail import DetailView
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from .forms import CamionForm
from django.contrib.auth.mixins import LoginRequiredMixin

from django.urls import reverse_lazy

class CamionListView(ListView):
    model = Camion

class CamionDetailView(DetailView):
    model = Camion

class CamionCreateView(LoginRequiredMixin, CreateView):
    login_url = '/cuentas/login/'
    model = Camion
    form_class = CamionForm
    success_url = reverse_lazy('listado')

class CamionUpdateView(LoginRequiredMixin, UpdateView):
    login_url = '/cuentas/login/'
    model = Camion
    form_class = CamionForm
    template_name_suffix = '_update_form'
    success_url = reverse_lazy('listado')

class CamionDeleteView(LoginRequiredMixin, DeleteView):
    login_url = '/cuentas/login/'
    model = Camion
    success_url = reverse_lazy('listado')