package com.grosalex.moviedb.contract

interface DetailContract {
    interface View{
        fun bind()
        fun error(message:String)
    }

    interface Presenter{

    }

    interface Provider
}