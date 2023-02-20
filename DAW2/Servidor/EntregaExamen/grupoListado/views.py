from principal.models import Grupo, Profesor
from django.template import loader
from django.http import HttpResponse

# Create your views here.
def grupos(request, identificador):
    grupo = Grupo.objects.get(id=identificador)
    context = {
        'profesor_list': grupo.profesor_set.all,
    }
    plantilla = loader.get_template('principal/profesor_list.html')
    return HttpResponse(plantilla.render(context, request))
