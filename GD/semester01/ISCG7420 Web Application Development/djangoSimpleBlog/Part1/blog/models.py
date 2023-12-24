from django.contrib.auth.models import User
from django.db import models

# Create your models here.
class Category(models.Model):
    name = models.CharField(max_length=30)


class Post(models.Model):
    title = models.CharField(max_length=200)
    title_tag = models.CharField(max_length=200,null=True,blank=True)
    author = models.ForeignKey(User, on_delete=models.CASCADE)
    body = models.TextField()
    post_date=models.DateTimeField(auto_now_add=True)
    snippet = models.CharField(max_length=200,null=True, blank=True)
    category = models.ForeignKey(Category,on_delete=models.CASCADE)
    likes=models.ManyToManyField(User, related_name='post_likes', null=True,blank=True)

class Comment(models.Model):
    post= models.ForeignKey(Post, on_delete=models.CASCADE)
    user= models.ForeignKey(User, on_delete=models.CASCADE,related_name='user_comments')
    body= models.TextField()
    date_added= models.DateField(auto_now_add=True)

class Profile(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    bio = models.TextField()
    website = models.CharField(max_length=255, blank=True)

    def __str__(self):
        return self.user.username + ' ' + self.user.last_name







