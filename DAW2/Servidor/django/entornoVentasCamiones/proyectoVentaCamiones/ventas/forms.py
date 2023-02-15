from django import forms
from .models import Camion

class CamionForm(forms.ModelForm):
    class Meta:
        model = Camion
        fields = ['titulo', 'marca', 'modelo', 'descripcion', 'precio', 'kilometros', 'imagen', 'author', 'categorias']
        widgets = {
            'titulo': forms.TextInput(attrs={'class': 'form__input','placeholder': 'Titulo'}),
            'marca': forms.TextInput(attrs={'class': 'form__input', 'placeholder': 'Marca'}),
            'modelo': forms.TextInput(attrs={'class': 'form__input', 'placeholder': 'Modelo'}),
            'descripcion': forms.Textarea(attrs={'class': 'form__input', 'placeholder': 'Descripcion'}),
            'precio': forms.TextInput(attrs={'class': 'form__input', 'placeholder': 'Precio'}),
            'kilometros': forms.TextInput(attrs={'class': 'form__input', 'placeholder': 'KM'}),
        }
        labels = {
            'titulo': '',
            'marca': '',
            'modelo': '',
            'descripcion': '',
            'precio': '',
            'kilometros': '',
        }