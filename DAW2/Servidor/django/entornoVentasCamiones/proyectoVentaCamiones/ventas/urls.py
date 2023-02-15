from django.urls import path
from .views import CamionListView, CamionDetailView, CamionCreateView, CamionUpdateView, CamionDeleteView

urlpatterns = [
    path('', CamionListView.as_view(), name='listado'),
    path('ventas/<int:pk>', CamionDetailView.as_view(), name='detalle'),
    path('crearCamion', CamionCreateView.as_view(), name='crear'),
    path('modificarCamion/<int:pk>', CamionUpdateView.as_view(), name='modificar'),
    path('borrarCamion/<int:pk>', CamionDeleteView.as_view(), name='borrar'),
]