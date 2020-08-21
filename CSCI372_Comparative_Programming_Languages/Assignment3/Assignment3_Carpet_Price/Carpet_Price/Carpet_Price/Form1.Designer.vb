<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.CarpetData = New System.Windows.Forms.GroupBox()
        Me.pricetxt = New System.Windows.Forms.TextBox()
        Me.styletxt = New System.Windows.Forms.TextBox()
        Me.colortxt = New System.Windows.Forms.TextBox()
        Me.pricelbl = New System.Windows.Forms.Label()
        Me.stylelbl = New System.Windows.Forms.Label()
        Me.colorlbl = New System.Windows.Forms.Label()
        Me.RoomSize = New System.Windows.Forms.GroupBox()
        Me.areatxt = New System.Windows.Forms.TextBox()
        Me.lengthtxt = New System.Windows.Forms.TextBox()
        Me.widthtxt = New System.Windows.Forms.TextBox()
        Me.arealbl = New System.Windows.Forms.Label()
        Me.lengthlbl = New System.Windows.Forms.Label()
        Me.widthlbl = New System.Windows.Forms.Label()
        Me.totallbl = New System.Windows.Forms.Label()
        Me.totaltxt = New System.Windows.Forms.TextBox()
        Me.calculatebtn = New System.Windows.Forms.Button()
        Me.clearbtn = New System.Windows.Forms.Button()
        Me.exitbnt = New System.Windows.Forms.Button()
        Me.sqrftlbl = New System.Windows.Forms.Label()
        Me.CarpetData.SuspendLayout()
        Me.RoomSize.SuspendLayout()
        Me.SuspendLayout()
        '
        'CarpetData
        '
        Me.CarpetData.Controls.Add(Me.sqrftlbl)
        Me.CarpetData.Controls.Add(Me.pricetxt)
        Me.CarpetData.Controls.Add(Me.styletxt)
        Me.CarpetData.Controls.Add(Me.colortxt)
        Me.CarpetData.Controls.Add(Me.pricelbl)
        Me.CarpetData.Controls.Add(Me.stylelbl)
        Me.CarpetData.Controls.Add(Me.colorlbl)
        Me.CarpetData.Location = New System.Drawing.Point(12, 12)
        Me.CarpetData.Name = "CarpetData"
        Me.CarpetData.Size = New System.Drawing.Size(265, 124)
        Me.CarpetData.TabIndex = 0
        Me.CarpetData.TabStop = False
        Me.CarpetData.Text = "Carpet Data:"
        '
        'pricetxt
        '
        Me.pricetxt.Location = New System.Drawing.Point(60, 77)
        Me.pricetxt.Name = "pricetxt"
        Me.pricetxt.Size = New System.Drawing.Size(100, 20)
        Me.pricetxt.TabIndex = 2
        '
        'styletxt
        '
        Me.styletxt.Location = New System.Drawing.Point(60, 51)
        Me.styletxt.Name = "styletxt"
        Me.styletxt.Size = New System.Drawing.Size(100, 20)
        Me.styletxt.TabIndex = 1
        '
        'colortxt
        '
        Me.colortxt.Location = New System.Drawing.Point(60, 25)
        Me.colortxt.Name = "colortxt"
        Me.colortxt.Size = New System.Drawing.Size(100, 20)
        Me.colortxt.TabIndex = 0
        '
        'pricelbl
        '
        Me.pricelbl.AutoSize = True
        Me.pricelbl.Location = New System.Drawing.Point(20, 80)
        Me.pricelbl.Name = "pricelbl"
        Me.pricelbl.Size = New System.Drawing.Size(34, 13)
        Me.pricelbl.TabIndex = 2
        Me.pricelbl.Text = "Price:"
        '
        'stylelbl
        '
        Me.stylelbl.AutoSize = True
        Me.stylelbl.Location = New System.Drawing.Point(20, 54)
        Me.stylelbl.Name = "stylelbl"
        Me.stylelbl.Size = New System.Drawing.Size(33, 13)
        Me.stylelbl.TabIndex = 1
        Me.stylelbl.Text = "Style:"
        '
        'colorlbl
        '
        Me.colorlbl.AutoSize = True
        Me.colorlbl.Location = New System.Drawing.Point(20, 28)
        Me.colorlbl.Name = "colorlbl"
        Me.colorlbl.Size = New System.Drawing.Size(34, 13)
        Me.colorlbl.TabIndex = 0
        Me.colorlbl.Text = "Color:"
        '
        'RoomSize
        '
        Me.RoomSize.Controls.Add(Me.areatxt)
        Me.RoomSize.Controls.Add(Me.lengthtxt)
        Me.RoomSize.Controls.Add(Me.widthtxt)
        Me.RoomSize.Controls.Add(Me.arealbl)
        Me.RoomSize.Controls.Add(Me.lengthlbl)
        Me.RoomSize.Controls.Add(Me.widthlbl)
        Me.RoomSize.Location = New System.Drawing.Point(283, 12)
        Me.RoomSize.Name = "RoomSize"
        Me.RoomSize.Size = New System.Drawing.Size(271, 124)
        Me.RoomSize.TabIndex = 1
        Me.RoomSize.TabStop = False
        Me.RoomSize.Text = "Room Size:"
        '
        'areatxt
        '
        Me.areatxt.Location = New System.Drawing.Point(70, 77)
        Me.areatxt.Name = "areatxt"
        Me.areatxt.ReadOnly = True
        Me.areatxt.Size = New System.Drawing.Size(100, 20)
        Me.areatxt.TabIndex = 2
        Me.areatxt.TabStop = False
        '
        'lengthtxt
        '
        Me.lengthtxt.Location = New System.Drawing.Point(70, 51)
        Me.lengthtxt.Name = "lengthtxt"
        Me.lengthtxt.Size = New System.Drawing.Size(100, 20)
        Me.lengthtxt.TabIndex = 1
        '
        'widthtxt
        '
        Me.widthtxt.Location = New System.Drawing.Point(70, 25)
        Me.widthtxt.Name = "widthtxt"
        Me.widthtxt.Size = New System.Drawing.Size(100, 20)
        Me.widthtxt.TabIndex = 0
        '
        'arealbl
        '
        Me.arealbl.AutoSize = True
        Me.arealbl.Location = New System.Drawing.Point(26, 80)
        Me.arealbl.Name = "arealbl"
        Me.arealbl.Size = New System.Drawing.Size(32, 13)
        Me.arealbl.TabIndex = 2
        Me.arealbl.Text = "Area:"
        '
        'lengthlbl
        '
        Me.lengthlbl.AutoSize = True
        Me.lengthlbl.Location = New System.Drawing.Point(26, 54)
        Me.lengthlbl.Name = "lengthlbl"
        Me.lengthlbl.Size = New System.Drawing.Size(43, 13)
        Me.lengthlbl.TabIndex = 1
        Me.lengthlbl.Text = "Length:"
        '
        'widthlbl
        '
        Me.widthlbl.AutoSize = True
        Me.widthlbl.Location = New System.Drawing.Point(26, 28)
        Me.widthlbl.Name = "widthlbl"
        Me.widthlbl.Size = New System.Drawing.Size(38, 13)
        Me.widthlbl.TabIndex = 0
        Me.widthlbl.Text = "Width:"
        '
        'totallbl
        '
        Me.totallbl.AutoSize = True
        Me.totallbl.Location = New System.Drawing.Point(197, 149)
        Me.totallbl.Name = "totallbl"
        Me.totallbl.Size = New System.Drawing.Size(58, 13)
        Me.totallbl.TabIndex = 2
        Me.totallbl.Text = "Total Cost:"
        '
        'totaltxt
        '
        Me.totaltxt.Location = New System.Drawing.Point(261, 146)
        Me.totaltxt.Name = "totaltxt"
        Me.totaltxt.ReadOnly = True
        Me.totaltxt.Size = New System.Drawing.Size(100, 20)
        Me.totaltxt.TabIndex = 3
        Me.totaltxt.TabStop = False
        '
        'calculatebtn
        '
        Me.calculatebtn.Location = New System.Drawing.Point(137, 193)
        Me.calculatebtn.Name = "calculatebtn"
        Me.calculatebtn.Size = New System.Drawing.Size(75, 23)
        Me.calculatebtn.TabIndex = 3
        Me.calculatebtn.Text = "Calculate"
        Me.calculatebtn.UseVisualStyleBackColor = True
        '
        'clearbtn
        '
        Me.clearbtn.Location = New System.Drawing.Point(261, 193)
        Me.clearbtn.Name = "clearbtn"
        Me.clearbtn.Size = New System.Drawing.Size(75, 23)
        Me.clearbtn.TabIndex = 4
        Me.clearbtn.Text = "Clear"
        Me.clearbtn.UseVisualStyleBackColor = True
        '
        'exitbnt
        '
        Me.exitbnt.Location = New System.Drawing.Point(378, 193)
        Me.exitbnt.Name = "exitbnt"
        Me.exitbnt.Size = New System.Drawing.Size(75, 23)
        Me.exitbnt.TabIndex = 5
        Me.exitbnt.Text = "Exit"
        Me.exitbnt.UseVisualStyleBackColor = True
        '
        'sqrftlbl
        '
        Me.sqrftlbl.AutoSize = True
        Me.sqrftlbl.Location = New System.Drawing.Point(47, 104)
        Me.sqrftlbl.Name = "sqrftlbl"
        Me.sqrftlbl.Size = New System.Drawing.Size(90, 13)
        Me.sqrftlbl.TabIndex = 5
        Me.sqrftlbl.Text = "( per square foot )"
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(566, 236)
        Me.Controls.Add(Me.exitbnt)
        Me.Controls.Add(Me.clearbtn)
        Me.Controls.Add(Me.calculatebtn)
        Me.Controls.Add(Me.totaltxt)
        Me.Controls.Add(Me.totallbl)
        Me.Controls.Add(Me.RoomSize)
        Me.Controls.Add(Me.CarpetData)
        Me.Name = "Form1"
        Me.Text = "Carpet Price"
        Me.CarpetData.ResumeLayout(False)
        Me.CarpetData.PerformLayout()
        Me.RoomSize.ResumeLayout(False)
        Me.RoomSize.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents CarpetData As GroupBox
    Friend WithEvents pricetxt As TextBox
    Friend WithEvents styletxt As TextBox
    Friend WithEvents colortxt As TextBox
    Friend WithEvents pricelbl As Label
    Friend WithEvents stylelbl As Label
    Friend WithEvents colorlbl As Label
    Friend WithEvents RoomSize As GroupBox
    Friend WithEvents areatxt As TextBox
    Friend WithEvents lengthtxt As TextBox
    Friend WithEvents widthtxt As TextBox
    Friend WithEvents arealbl As Label
    Friend WithEvents lengthlbl As Label
    Friend WithEvents widthlbl As Label
    Friend WithEvents totallbl As Label
    Friend WithEvents totaltxt As TextBox
    Friend WithEvents calculatebtn As Button
    Friend WithEvents clearbtn As Button
    Friend WithEvents exitbnt As Button
    Friend WithEvents sqrftlbl As Label
End Class
