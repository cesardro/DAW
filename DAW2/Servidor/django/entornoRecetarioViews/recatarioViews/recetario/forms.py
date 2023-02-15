from django import forms
from .models import Receta

class RecetaForm(forms.ModelForm):
    class Meta:
        model = Receta
        fields = ['nombre', 'subnombre', 'ingredientes', 'receta', 'categorias', 'author', 'imagen']
        widgets = {
            'nombre': forms.TextInput(attrs = {'style': 'background-color: red'}),
            'subnombre': forms.TextInput(attrs = {'style': 'background-color: grey', 'placeholder': 'Escribe el subnombre'}),
            'ingredientes': forms.Textarea(attrs = {'class':'btn'}),
        }
        labels = {
            'nombre':'',
            'subnombre': '',
        }