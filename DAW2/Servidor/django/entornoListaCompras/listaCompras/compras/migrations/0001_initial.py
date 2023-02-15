# Generated by Django 4.1.5 on 2023-01-10 11:52

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='compras',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('producto', models.CharField(max_length=255)),
                ('cantidad', models.FloatField()),
                ('unidad', models.CharField(max_length=255)),
                ('comprada', models.BooleanField()),
            ],
        ),
    ]
