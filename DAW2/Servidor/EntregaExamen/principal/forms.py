from django import forms
from .models import Profesor

class ProfesorForm(forms.ModelForm):
    class Meta:
        model = Profesor
        fields = ['nombre', 'apellidos', 'telefono', 'correo', 'asignatura', 'author', 'grupo']
        