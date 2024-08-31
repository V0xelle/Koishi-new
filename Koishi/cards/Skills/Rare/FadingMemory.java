/*    */ package Koishi.cards.Skills.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.FadingMemoryAction;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class FadingMemory
/*    */   extends AbstractIdCard {
/* 15 */   public static final String ID = KoishiMod.makeID(FadingMemory.class.getSimpleName());
/* 16 */   public static final String IMG = KoishiMod.makeCardPath("FadingMemory.png");
/*    */   
/* 18 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 19 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 20 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 21 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int EXHAUST = 1;
/*    */   
/*    */   private static final int DRAW = 2;
/*    */   private static final int UPGRADE_PLUS_DRAW = 1;
/*    */   
/*    */   public FadingMemory() {
/* 31 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 32 */     this.magicNumber = this.baseMagicNumber = 1;
/* 33 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 38 */     KoishiMod.runAnimation("spellCall");
/* 39 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new FadingMemoryAction(this));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 45 */     return 19.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 51 */     if (!this.upgraded) {
/* 52 */       upgradeName();
/* 53 */       upgradeDefaultSecondMagicNumber(1);
/* 54 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Rare/FadingMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */