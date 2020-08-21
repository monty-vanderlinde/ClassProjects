Public Class Form1
    Private Sub exitbnt_Click(sender As Object, e As EventArgs) Handles exitbnt.Click
        Me.Close()
    End Sub

    Private Sub clearbtn_Click(sender As Object, e As EventArgs) Handles clearbtn.Click
        colortxt.Clear()
        styletxt.Clear()
        pricetxt.Clear()
        widthtxt.Clear()
        lengthtxt.Clear()
        areatxt.Clear()
        totaltxt.Clear()
    End Sub

    Private Sub calculatebtn_Click(sender As Object, e As EventArgs) Handles calculatebtn.Click
        If colortxt.Text = "" Or styletxt.Text = "" Or pricetxt.Text = "" Or widthtxt.Text = "" Or lengthtxt.Text = "" Then
            Return
        End If

        Dim Price As Decimal
        Dim Width As Decimal
        Dim Length As Decimal

        If Not (Decimal.TryParse(pricetxt.Text, Price) And Decimal.TryParse(widthtxt.Text, Width) And Decimal.TryParse(lengthtxt.Text, Length)) Then
            Return
        End If

        Dim carpet As New Carpet(colortxt.Text, styletxt.Text, Price)
        Dim rectangle As New Rectangle(Width, Length)

        areatxt.Text = rectangle.TotalArea
        totaltxt.Text = FormatCurrency(carpet.PricePerSquareFoot * rectangle.TotalArea, 2)
    End Sub


    Public Class Carpet
        Private Color As String
        Private Style As String
        Private Price As Decimal

        Public Sub New(ByVal Color As String, ByVal Style As String, ByVal Price As Decimal)
            Me.Color = Color
            Me.Style = Style
            Me.Price = Price
        End Sub

        Public ReadOnly Property PricePerSquareFoot As Decimal
            Get
                Return Me.Price
            End Get
        End Property
    End Class

    Public Class Rectangle
        Private Width As Decimal
        Private Length As Decimal
        Private Area As Decimal

        Public Sub New(ByVal Width As Decimal, ByVal Length As Decimal)
            Me.Width = Width
            Me.Length = Length
            Me.Area = Width * Length
        End Sub

        Public ReadOnly Property TotalArea As Decimal
            Get
                Return Me.Area
            End Get
        End Property
    End Class
End Class
