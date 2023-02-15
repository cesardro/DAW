from django.urls import path
from .views import EmpresaListView, EmpresaDetailView, EmpresaCreateView, EmpresaUpdateView, EmpresaDeleteView

urlpatterns = [
    path('', EmpresaListView.as_view(), name='listado'),
    path('empresa/<int:pk>', EmpresaDetailView.as_view(), name='detalle'),
    path('crearEmpresa', EmpresaCreateView.as_view(), name='crear'),
    path('modificarEmpresa/<int:pk>', EmpresaUpdateView.as_view(), name='modificar'),
    path('borrarEmpresa/<int:pk>', EmpresaDeleteView.as_view(), name='borrar'),
]