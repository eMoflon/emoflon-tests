source MocaTree
target DictionaryLanguage

// Add your classes here (template available)
class FolderToLibrary {
	source -> Folder
	target -> Library
}

class FolderToShelf {
	source -> Folder
	target -> Shelf
}

class NodeToDictionary {
	source -> Node
	target -> Dictionary
}

class NodeToEntry {
	source -> Node
	target -> Entry
}

class NodeToAuthor {
	source -> Node
	target -> Author
}

