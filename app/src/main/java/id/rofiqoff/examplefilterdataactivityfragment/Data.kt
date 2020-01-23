package id.rofiqoff.examplefilterdataactivityfragment

data class Data(var textData: String)

val datas: ArrayList<Data>
    get() = arrayListOf<Data>().apply {
        add(Data("Real Madrid"))
        add(Data("Barcelona"))
        add(Data("Manchester United"))
        add(Data("Manchester City"))
        add(Data("Liverpool"))
        add(Data("Juventus"))
        add(Data("Chelsea"))
        add(Data("Atletico Madrid"))
        add(Data("Paris Saint German"))
        add(Data("Ac Milan"))
        add(Data("Inter Milan"))
        add(Data("AS Roma"))
    }