# Spitter project
## Overview

The Spitter Project is a simple Java application that allows users to manage "Spitter" (users) and "Spittles" (messages) objects.

Users can preform **CRUD** operations on users, messages

## Features
- **Spitter Managment**: Create, read, update, delete.
- **Splittle Managment**: Create, read, update, delete.
- **User/Message Relation**: Each splitter can have multiple messages (Spittles).

## Class Descriptions
- **Main**: Main entry point to initialize application, creates data
- **Splitter**: Represents a user with fname, lname, id, password, list of messages (Splittles).
- **Splittle**: Represents a message with unique id, containing text, authorId, receiverid, sentDate, List to contain history of changes.
- **Splitter Service**: Contains methods for CRUD operations on Splitter and Splittle objects
