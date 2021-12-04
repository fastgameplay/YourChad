package com.asl.yourchad
class Validate {
    companion object{
        fun email(input : String):Boolean{
            if(input.isNotEmpty() && input.contains(Regex("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}")) ) return true
            return false
        }
        fun username(input: String):Boolean{
            return (input.length <21)
        }
        fun password(input : String):Boolean{
            if( input.length >8 &&
                input.contains(Regex("[a-z]")) &&
                input.contains(Regex("[A-Z]")) &&
                input.contains(Regex("[0-9]")) &&
                input.contains(Regex("[^a-zA-Z0-9]"))  // symbolos check
            ) return true
            return false
        }
        fun password(input: String,id: Int):Boolean{
            if (id == 0 && input.contains(Regex("[a-z]"))) return true
            if (id == 1 && input.contains(Regex("[A-Z]"))) return true
            if (id == 2 && input.contains(Regex("[0-9]"))) return true
            if (id == 3 && input.contains(Regex("[^a-zA-Z0-9]"))) return true
            return false
        }
    }

}