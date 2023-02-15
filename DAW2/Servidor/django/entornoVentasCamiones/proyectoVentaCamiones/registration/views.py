from .forms import UsuarioCrearFormConEmail
from django.views.generic.edit import CreateView
from django.urls import reverse_lazy
from django import forms

# Create your views here.
class RegistroView(CreateView):
    form_class = UsuarioCrearFormConEmail
    template_name = 'registration/registro.html'

    def get_success_url(self) -> str:
        return reverse_lazy('login') + '?registrado'

    def get_form(self, form_class=None):
        form = super(RegistroView, self).get_form()
        form.fields['username'].widget = forms.TextInput(attrs ={'style':'background-color:orange','placeholder':'Nombre de usuario'})
        form.fields['email'].widget = forms.TextInput(attrs ={'style':'background-color:orange','placeholder':'E-mail'})
        return form