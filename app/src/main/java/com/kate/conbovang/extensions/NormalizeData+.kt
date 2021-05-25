package com.kate.conbovang.extensions


fun String.normalize(): String {
    if(contains("#*#")){
        return this.split("#*#")[0]
    }else if(contains("#@$")){
        return this.split("#@$")[0]
    }
    return this
}