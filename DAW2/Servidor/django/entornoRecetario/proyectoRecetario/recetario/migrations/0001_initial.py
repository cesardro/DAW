# Generated by Django 4.1.5 on 2023-01-19 08:03

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Categorias',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombre', models.CharField(max_length=255)),
                ('descricion', models.TextField(null=True)),
            ],
        ),
        migrations.CreateModel(
            name='Receta',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombre', models.CharField(max_length=255)),
                ('subnombre', models.CharField(max_length=255, null=True)),
                ('imagen', models.CharField(max_length=255, null=True)),
                ('ingredientes', models.TextField(null=True)),
                ('receta', models.TextField(null=True)),
            ],
        ),
    ]