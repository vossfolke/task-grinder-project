BACKEND:
  REST API:
    TASKS:
      create Task Post(/task) with body: name, value. Id is set automaticly.
      update Task Put(/task/{id}) with body: name, value, {id}
      delete Task Delete(/task/{id})
      get Task Get(/task/{id}) gives body with name, value, {id}
      get all Tasks Get(/task/all) gives a List if Tasks
