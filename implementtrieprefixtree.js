//Objective is to design a trie/prefix tree.


//Design of a trie using a nested hashmap.

class Trie {
    constructor() {
        this.root = {}
    } 

    insert(word) {
        let node = this.root 
        for (let char of word) {
            if (!node[char]) {
                node[char] = {}
            }
            node = node[char]
        }

        node.isEnd = true
    }

    search(word) {
        let node = this.searchNode(word)
        return node == null ? false : node.isEnd == true
    }

    startWith(prefix) {
        let node = this.searchNode(prefix)
        return node !== null
    }

    searchNode(word) {
        let root = this.root 
        for (let char of word) {
            if (!root[char]) {
                return null
            } else {
                root = root[char]
            }
        }

        return root
    }
}

let trie = new Trie()
trie.insert("apple")
trie.search("apple")   
trie.search("app") 
trie.startsWith("app") 
trie.insert("app")   
trie.search("app")     