from django.urls import path
from .views import RecetarioListView, RecetarioDetailView, RecetarioCreateView, RecetarioUpdateView, RecetarioDeleteView, RecetarioEspecificaListView

urlpatterns = [
    path('', RecetarioListView.as_view(), name='listado'),
    path('recetario/<int:pk>', RecetarioDetailView.as_view(), name='detalle'),
    path('crearRecetario', RecetarioCreateView.as_view(), name='crear'),
    path('modificarRecetario/<int:pk>', RecetarioUpdateView.as_view(), name='modificar'),
    path('borrarRecetario/<int:pk>', RecetarioDeleteView.as_view(), name='borrar'),
    path('recetasEspecificas/<str:pk>', RecetarioEspecificaListView.as_view(), name='recetasEspecificas'),
]