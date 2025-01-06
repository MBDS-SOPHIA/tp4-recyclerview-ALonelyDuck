[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pP2-IVlX)
# Prise en main des tests sur Android 
Dans ce TP vous allez apprendre à manipuler les recyclerviews dans une application Android, effectuer des tests unitaires et d'interfaces. 

## Travaux à réaliser 
1. Accepter l'assignment sur Github Classrooms
2. Cloner le projet sur Android Studio
3. Modifiez la section `Contributeurs` pour y ajouter les membres du groupe
4. Faire un commit puis push sur Github
5. Consulter le repo du projet sur Github (votre Github bien sure), que remarquez-vous ? Vous devriez avoir reçu un mail...

Il y a un workflow Github Action qui est configuré pour exécuter les tests unitaires et d'interfaces.
Ces tests échouent pour le moment.

### Etape 1: Fixer les tests
1. Exécuter les tests  
   -  Lancer les tests unitaires
   -  Lancer les tests d'interfaces
2. Que remarquez-vous ? 

```
UserRepositoryTest > generateRandomUserWithSuccess FAILED
kotlin.NotImplementedError at UserRepositoryTest.kt:41

UserRepositoryTest > getUsersWithSuccess FAILED
kotlin.NotImplementedError at UserRepositoryTest.kt:31

UserRepositoryTest > deleteUserWithSuccess FAILED
kotlin.NotImplementedError at UserRepositoryTest.kt:54

3 tests completed, 3 failed
```

3. Corrigner les erreurs

J'ai complété les methodes TODO de UserRepository.kt, classe qui dépend de FakeApiService.kt
qui avait aussi des methodes à compléter.

4. Relancer les tests (unitaires et d'interfaces)
6. Commit et push vos changements. Logiquement, vous devriez avoir un flag vert sur le repo. 

### Etape 2: Gestion des images de profile
1. Exécutez l'application sur un téléphone ou un émulateur
2. Les images de profile ne s'affichent pas, trouvez et corrigez l'erreur

L'avatarUrl dans FakeApiServiceGenerator n'était plus bon, j'ai donc changé l'url pour une autre image.
Tout est maintenant fonctionnel.

3. Commit et push les derniers changements. 

## Etape 3 : Améliorer l'application
1. Utiliser le viewbinding pour référencer les éléments de vues dans l'acitivité et l'adapter
2. Implémenter une fonctionnalité permattant d'activer ou désactiver un utilisateur en swipant la cellule à gauche ou à droite;
>> Quand l'utiliateur est inactif (i.e. désactivé) on met un background 'rouge' sur la cellule quand il est activé on met un background blanc.
3. Adapter les tests unitaires pour prendre en compte les derniers changements (i.e. actif vs inactif)
4. Gestion de l'ordonnancement des éléments de la liste en autorisant le déplacement des cellules.

## Bonus 
- Modifier les tests d'inferfaces

# Contributeurs
