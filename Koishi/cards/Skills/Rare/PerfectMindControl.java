/*    */ package Koishi.cards.Skills.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.MindControlPower;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class PerfectMindControl extends AbstractDefaultCard {
/* 20 */   public static final String ID = KoishiMod.makeID(PerfectMindControl.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("PerfectMindControl.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 3;
/*    */   
/*    */   private static final int TURNS = 1;
/*    */   
/*    */   public PerfectMindControl() {
/* 33 */     super(ID, IMG, 3, TYPE, COLOR, RARITY, TARGET);
/* 34 */     this.magicNumber = this.baseMagicNumber = 1;
/* 35 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 40 */     KoishiMod.runAnimation("perfectMindControl");
/* 41 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 42 */     while (iterator.hasNext()) {
/* 43 */       AbstractMonster mo = iterator.next();
/* 44 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new MindControlPower((AbstractCreature)mo, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 51 */     return 17.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 57 */     if (!this.upgraded) {
/* 58 */       upgradeName();
/* 59 */       AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/* 60 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 61 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Rare/PerfectMindControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */