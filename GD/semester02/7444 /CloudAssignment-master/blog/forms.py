from django import forms

from blog.models import Boat


class BoatForm(forms.ModelForm):
    class Meta:
        model = Boat
        fields = ('name', 'owner', 'description', 'built', 'length', 'price')
        widgets = {
            'name': forms.TextInput(attrs={'class':'form-control'}),
            'owner': forms.Select(attrs={'class':'form-control'}),
            'description': forms.Textarea(attrs={'class':'form-control'}),
            'built': forms.NumberInput(attrs={'class':'form-control'}),
            'length': forms.NumberInput(attrs={'class':'form-control'}),
            'price': forms.NumberInput(attrs={'class':'form-control'}),
        }
class UpdateBoatForm(forms.ModelForm):
    class Meta:
        model = Boat
        fields = ('description', 'built', 'length', 'price')
        widgets = {
            'description': forms.Textarea(attrs={'class':'form-control'}),
            'built': forms.NumberInput(attrs={'class':'form-control'}),
            'length': forms.NumberInput(attrs={'class':'form-control'}),
            'price': forms.NumberInput(attrs={'class':'form-control'}),
        }