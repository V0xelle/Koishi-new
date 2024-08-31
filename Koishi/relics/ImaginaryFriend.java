/*    */ package Koishi.relics;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.powers.EphemeralPower;
/*    */ import Koishi.util.TextureLoader;
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.UseCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ public class ImaginaryFriend extends CustomRelic {
/* 19 */   public static final String ID = KoishiMod.makeID("ImaginaryFriend");
/*    */   
/* 21 */   private static final Texture IMG = TextureLoader.getTexture(KoishiMod.makeRelicPath("ImaginaryFriend.png"));
/* 22 */   private static final Texture OUTLINE = TextureLoader.getTexture(KoishiMod.makeRelicOutlinePath("ImaginaryFriend.png"));
/*    */   
/*    */   private static final int EPHEMERAL = 1;
/*    */   
/*    */   public ImaginaryFriend() {
/* 27 */     super(ID, IMG, OUTLINE, AbstractRelic.RelicTier.STARTER, AbstractRelic.LandingSound.MAGICAL);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
/* 32 */     flash();
/* 33 */     AbstractPlayer p = AbstractDungeon.player;
/* 34 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EphemeralPower((AbstractCreature)p, 1), 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 39 */     return this.DESCRIPTIONS[0] + '\001' + this.DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/relics/ImaginaryFriend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */